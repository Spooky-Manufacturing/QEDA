# QEDA Development Log

Due to the increasing complexities of this project, we will now be keeping a development log detailing changes made during the development lifecycle.

## IR Generation & Big-O Optimization

#### 11/01/2021: 

We've abstracted the self.GLOBALS and self.LOCALS variables of the QEDAListener class into a few different parts:

self.DECLARATIONS - Holds the locally and globally declared variables (i.e. qubit[n]; bit[n]; etc.)

self.STMTS - Holds the statements (actual instructions performed) in-order.

self.FUNCTIONS - Holds subroutines, loops, and gate definitions.

Doing this allows us to avoid iterating over this data multiple times, instead the synthesizer can simply parse through self.STMTS pulling data from self.DECLARATIONS and self.FUNCTIONS ala-carte. Additionally, enterProgram processing is performed within a single while loop rather than two separate while loops.

A future optimization we can start planning for is the integration of the IR construction code and the translation code such that all of the aforementioned logic performed via the Synthesizer class can be done in a single while loop removing yet another big-O complexity. Another optimization would be to only parse the necessary sections of the include file, although I haven't completely figured out a good way to do this. As is, the best we can hope for is an O number of O(n x m) [basically, n*2].

Can we frigging organize the code base? Holy smokes it's getting spaghetti up in here, we're probably also going to want to delete the entire synth folder, it will be easier to start fresh with the new synthesizer than trying to rewrite the old core classes.

Maybe we can move anything not specifically related to OpenQASM out of the OpenQASM folder too? It's an idea after all. - Noah

#### 11/02/2021: 

Lol wtf am I even doing? Abstracted QCode even further to separate bits, qubits,constants, and statements. This way we don't need to do additional processing. We might wind up combining the synthesizer and listener code when we optimize more, but I'd prefer keeping them as decoupled as possible (kinda the whole reason I created the QCode IR was to keep things generalized, seems to be increasing the complexity though). Oh well, onwards we go with our somewhat-coupled codebase.

