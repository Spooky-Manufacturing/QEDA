# Built-In Gates

All of the single-qubit unitary gates are built-in and parameterized as

```openqasm
U(θ, ϕ, λ) !=
Rx(θ) := [
		cos(θ/2)	-isin(θ/2)
		-isin(θ/2)	cos(θ/2)
		]
Ry(ϕ) := [
		cos(ϕ/2)	-sin(ϕ/2)
		sin(ϕ/2)	cos(ϕ/2)
		]
Rz(λ) := [
		exp(-iλ/2)	0
		0			exp(iλ/2)
		]
```

```
U(θ, ϕ, λ) :=
Rz(ϕ-pi/2)
Rx(pi/2)
Rz(pi-θ)
Rx(pi/2)
Rz(λ-pi/2)

   U(π/2, 0, π)
   
[
	sqrt(i)	0
	0	sqrt(-i)
]
[
	1	0
	0	1
]
[
	sqrt(-i)	0
	0	sqrt(i)
]
[
	1	0
	0	1
]
[
	sqrt(-i)	0
	0		sqrt(i)
]
```

# Optimizations

### Gate Bypassing

Gate bypassing allows us to bypass running the computationally intensive algorithms necessary to decompose a given quantum gate. Gates that have been solved are added to a local database and gates can also be fetched from our remote database.

### Built In Bypassed Gates (planned)

* Pauli-X := U(π, 0, π)
* Pauli-Y := U(π, π/2, π/2)
* Pauli-Z := p(π)
* Identity := U(0,0,0)
* Clifford-Hadamard := U(π/2, 0, π)
* Clifford-S := pow(1/2) @ z
* CX := ctrl @ x
* CY := ctrl @ y
* CZ := ctrl @ z
* CH := ctrl @ h