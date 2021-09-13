# QEDA
Quantum Electronics Design Automation - The RTL of Quantum Computing!

## What is the purpose of QEDA?
The purpose of QEDA is to provide an open-source synthesizer for the [OpenQASM](https://github.com/Qiskit/openqasm) language. Much like Verilog and VHDL are used to define digital circuits, OpenQASM is a language used to describe quantum circuits making it the perfect language for us to build our synthesizer around.

## Targeted Paradigm
* **LOQC** *(Linear Optical Quantum Computing)*.

## Targeted Language
* OpenQASM V3.x 
  - [Language support provided by OpenQASM-LanguageSupport](https://github.com/NoahGWood/OpenQASM-LanguageSupport)

## Short Term Goals
* Integration with [SpookyMFG's Universal Quantum Gate Set](https://github.com/Spooky-Manufacturing/UniversalGateSet)
* Support for custom gates utilizing SpookyMFG's universal gates.
  - Planned fulfillment by use of gate decomposition algorithms:
    - **Immediate need for Shannon Decomposition Algorithm Integration**
    - (future) Davio Algorithm Integration
* Circuit success rate & time-to-success (TTS) estimation 
* Automated Schematic Synthesis (Internal)
* Automated PCB Layout (Internal)
* Automated integration with SpookyMFG's [Q-Ctrl backends](https://github.com/Spooky-Manufacturing/QCtrl)
* ~~GUI~~ [Fulfilled by SpookyIDE!](https://github.com/Spooky-Manufacturing/SpookyIDE!)
* QASM Language Syntax Highlighting [Fulfilled by OpenQASM-LanguageSupport](https://github.com/NoahGWood/OpenQASM-LanguageSupport)

## Mid Term Goals
* Schematic Viewer ~~(internal)~~ [Nearly fulfilled by kicad-vscode](https://github.com/NoahGWood/kicad-vscode)
* PCB Viewer ~~(internal)~~ [Nearly fulfillment by kicad-vscode]() 
* Circuit Simulation 

## Long Term Goals
* ~~Support for custom gate design utilizing user-defined bloch-sphere rotations & non-linear operations.~~ **To be fulfilled by gate decomposition.**
* Synthesis-to-Chip **ISO Chip foundaries with optical engineering capabilities!**
* 3D Circuit View 
* ~~Advanced simulations~~ Will likely integrate SpookyIDE with QisKit for this functionality.
