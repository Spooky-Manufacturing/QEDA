/*
 * quantum RNG
 */
OPENQASM 3;
include "stdgates.inc";

qubit a;
reset a;
h a;
x a;
measure a;
