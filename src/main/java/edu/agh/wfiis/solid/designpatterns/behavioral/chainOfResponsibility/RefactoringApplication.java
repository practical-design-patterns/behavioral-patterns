package edu.agh.wfiis.solid.designpatterns.behavioral.chainOfResponsibility;

import java.text.MessageFormat;

public class RefactoringApplication {


    public static void main(String[] args)
    {
        Refactorable code = new LegacyCode();
        Refactoring builder = new Builder();
        Refactoring abstractFactory = new AbstractFactory();
        Refactoring decorator = new Decorator();
        Refactoring facade = new Facade();
        Refactoring strategy = new Strategy();


        if(code.containsSwitchCaseBlock()){
            code = abstractFactory.refactor(code);
            code = strategy.refactor(code);
        }

        if(code.containsTelescopingConstructor()){
            code = builder.refactor(code);
        }

        if(code.exposesComplexThirdPartyDependencies()){
            code = abstractFactory.refactor(code);
        }

        if(code.hasConvolutedInheritanceHierarchy()){
            code = decorator.refactor(code);
        }

    }
}

class LegacyCode implements Refactorable {


    @Override
    public boolean containsTelescopingConstructor() {
        return true;
    }

    @Override
    public boolean containsSwitchCaseBlock() {
        return true;
    }

    @Override
    public boolean hasConvolutedInheritanceHierarchy() {
        return true;
    }

    @Override
    public boolean exposesComplexThirdPartyDependencies() {
        return true;
    }
}

class Builder implements Refactoring {

    @Override
    public Refactorable refactor(Refactorable refactorable){
        System.out.println(MessageFormat.format("refactoring with {0} pattern...", this.getClass().getSimpleName()));
        //some magic happens here
        System.out.println("...done");
        return refactorable;
    }
}

class AbstractFactory implements Refactoring {

    @Override
    public Refactorable refactor(Refactorable refactorable){
        System.out.println(MessageFormat.format("refactoring with {0} pattern...", this.getClass().getSimpleName()));
        //some magic happens here
        System.out.println("...done");
        return refactorable;
    }
}


class Decorator implements Refactoring {

    @Override
    public Refactorable refactor(Refactorable refactorable){
        System.out.println(MessageFormat.format("refactoring with {0} pattern...", this.getClass().getSimpleName()));
        //some magic happens here
        System.out.println("...done");
        return refactorable;
    }
}

class Facade implements Refactoring {

    @Override
    public Refactorable refactor(Refactorable refactorable){
        System.out.println(MessageFormat.format("refactoring with {0} pattern...", this.getClass().getSimpleName()));
        //some magic happens here
        System.out.println("...done");
        return refactorable;
    }
}

class Strategy implements Refactoring {

    @Override
    public Refactorable refactor(Refactorable refactorable){
        System.out.println(MessageFormat.format("refactoring with {0} pattern...", this.getClass().getSimpleName()));
        //some magic happens here
        System.out.println("...done");
        return refactorable;
    }
}