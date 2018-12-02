package edu.agh.wfiis.solid.designpatterns.behavioral.visitor;

import edu.agh.wfiis.solid.designpatterns.behavioral.visitor.legacyCode.DesignPatternsManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RefactoringApplication {


    public static void main(String[] args)
    {
        ClassDependency rootClazz = new ClassDependency(DesignPatternsManager.class);
        rootClazz.refactor();
        for(ClassMethod method:rootClazz.getMethods()){
            method.refactor();
        }
        for(ClassDependency dependency:rootClazz.getDependencies()){
            dependency.refactor();
            for(ClassMethod method:rootClazz.getMethods()){
                method.refactor();
            }
            rootClazz = dependency;        }
    }
}

class ClassDependency implements ClassMember {
    private final Class clazz;


    ClassDependency(Class clazz) {
        this.clazz = clazz;
    }

    List<ClassMethod> getMethods(){
        return Arrays.stream(clazz.getMethods()).map(ClassMethod::new).collect(Collectors.toList());
    }

    List<ClassDependency> getDependencies(){
        return Arrays.stream(clazz.getFields()).map(Field::getType).map(ClassDependency::new).collect(Collectors.toList());
    }

    public void refactor() {
        Refactoring builder = new Builder();
        builder.refactor(this);

        StaticFactoryMethod staticFactoryMethod = new StaticFactoryMethod();
        staticFactoryMethod.refactor(this);
    }

    @Override
    public String toString(){
        return clazz.getSimpleName();
    }
}

class ClassMethod implements ClassMember {
    private final Method method;

    ClassMethod(Method method) {
        this.method = method;
    }

    @Override
    public void refactor() {
        Refactoring strategy = new Strategy();
        strategy.refactor(this);
    }

    @Override
    public String toString(){
        return method.getName();
    }
}

class Builder implements Refactoring {

    @Override
    public void refactor(ClassMember refactorable){
        System.out.println(MessageFormat.format("Refactoring {0} by Builder", refactorable.toString()));
    }
}


class Strategy implements Refactoring {

    @Override
    public void refactor(ClassMember refactorable){
        System.out.println(MessageFormat.format("Refactoring {0} by Strategy", refactorable.toString()));
    }
}

class StaticFactoryMethod implements Refactoring {

    @Override
    public void refactor(ClassMember refactorable){
        System.out.println(MessageFormat.format("Refactoring {0} by StaticFactoryMethod", refactorable.toString()));
    }
}