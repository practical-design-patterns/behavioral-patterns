package edu.agh.wfiis.solid.designpatterns.behavioral.chainOfResponsibility;

public interface Refactorable {

    boolean containsTelescopingConstructor();

    boolean containsSwitchCaseBlock();

    boolean hasConvolutedInheritanceHierarchy();

    boolean exposesComplexThirdPartyDependencies();

}
