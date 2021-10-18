# Synthesizer

Documentation for the QEDA synthesizer.



## Steps:

### 1. Parse globals for gate definitions

#### Steps

### 2. Parse globals for variable/constant declarations

### 3. Generate new gates: - Methods:

* Simply mux all the gates and replace the name with internal block on pcb
* create black-box components and use these instead (probably the best option)
* create gates from optical components (probably best to have this contained in schematic and made a black-box component)

### 4. Parse local code and build circuit representation



### 5. Create new schematic

- pull in generation info from user-defined files
- place components using placement algorithm

### 6. Create new pcb

* pull in generation info from user-defined files
* place components using placement algorithm