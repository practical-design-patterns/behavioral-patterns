package edu.agh.wfiis.solid.designpatterns.behavioral.visitor.legacyCode;

import java.io.File;

public class DesignPatternsManager {

    public DesignPattern create(PatternName patternName) {
        switch (patternName) {
            case BUILDER: {
                DesignPattern pattern = new DesignPattern("1","builder","builder pattern",null, null, true, false, false);
                return pattern;
            }
            case DECORATOR: {
                DesignPattern pattern = new DesignPattern("2","decorator","decorator pattern",null, null, false, true, false);
                return pattern;
            }
            case STRATEGY: {
                DesignPattern pattern = new DesignPattern("3","strategy","strategy pattern",null, null, false, false, true);
                return pattern;
            }
            default: {
                DesignPattern pattern = new UndefinedPattern();
                return pattern;
            }
        }
    }

    public String provideUsageExample(DesignPattern pattern){
        String example = pattern instanceof UndefinedPattern? null: pattern.getExample();
        return example;
    }

    public String refactorCode(DesignPattern pattern, String badCode){
        String goodCode = pattern instanceof UndefinedPattern? null: pattern.refactor(badCode);
        return goodCode;
    }

    public String listPatterns(){
        return PatternName.values().toString();
    }

    public boolean areSameType(DesignPattern pattern1, DesignPattern pattern2){
        return pattern1.isBehavioral() == pattern2.isBehavioral() && pattern1.isCreational() == pattern2.isCreational() && pattern1.isStructural() == pattern2.isStructural();
    }

    public String extractBadCodeFromFile(File file){
        /* some magic happens here, irrelevant from this example perspective...*/
        return "bad code from file";
    }

    public String extractBadCodeFromClassPath(ClassLoader classLoader){
        /* some magic happens here, irrelevant from this example perspective...*/
        return "bad code from class loader";
    }

    public String generateDesignPatternsCourseworkForStudents(){
        /* some magic happens here, irrelevant from this example perspective...*/
        return "very difficult coursework";
    }

}

enum PatternName {
    BUILDER, DECORATOR, STRATEGY;
}


class UndefinedPattern extends DesignPattern {

    public UndefinedPattern() {
        super(null,null,null, null,null, false, false, false);
    }

    public String refactor(String badCode){
        throw new UnsupportedOperationException();
    }

}
