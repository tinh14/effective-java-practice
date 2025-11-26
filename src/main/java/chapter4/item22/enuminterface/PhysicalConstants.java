package chapter4.item22.enuminterface;

// Using an interface to export constants can cause implementation details
// to leak into this class's API contract.
// If this class no longer needs to use the constants in subsequence releases.
// We cannot modify it because of the backward compatibility.
public interface PhysicalConstants {
    static final double AVOGADRO_CONSTANT = 6.022e23;
    static final double BOLTZMANN_CONSTANT = 1.380_649e-23;
    static final double ELECTRON_MASS = 9.109_383_7e-31;
}