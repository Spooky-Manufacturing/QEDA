# QEDA
Quantum Electronics Design Automation - The RTL of Quantum Computing!

## What is the purpose of QEDA?
The purpose of QEDA is to provide an open-source synthesizer for the [OpenQASM](https://github.com/Qiskit/openqasm) language. Much like Verilog and VHDL are used to define digital circuits, OpenQASM is a language used to describe quantum circuits making it the perfect language for us to build our synthesizer around.

## Targeted Paradigm
* **LOQC** *(Linear Optical Quantum Computing)*.

## Targeted Language
* OpenQASM V3.x

## Short Term Goals
* Integration with [SpookyMFG's Universal Quantum Gate Set](https://github.com/Spooky-Manufacturing/UniversalGateSet)
* Support for custom gates utilizing SpookyMFG's universal gates.
* Circuit success rate & time-to-success (TTS) estimation
* Automated PCB Layout
* Automated integration with SpookyMFG's [Q-Ctrl backends](https://github.com/Spooky-Manufacturing/QCtrl)
* GUI

## Mid Term Goals
* Board Editor (internal)
* Schematic Editor (internal)
* Circuit Simulation

## Long Term Goals
* Support for custom gate design utilizing user-defined bloch-sphere rotations & non-linear operations.
* Synthesis-to-Chip
* PCB View
* 3D Circuit View
* Advanced simulations
