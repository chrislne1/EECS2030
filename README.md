# Sequence Expression Evaluator (Java)

## Project Overview
This project implements a sequence expression evaluation framework in Java. The system models operations over integer sequences, including projections, prefix sums, and containment checks, as well as evaluators that combine or filter the results of these operations.

All required behavior, constraints, and design expectations are defined entirely through JUnit tests, which act as executable specifications for the system.

## System Components
The system is built around the following core abstractions:

### Sequence Operations
- **SeqOperation**: common abstraction for all sequence-related operations
- **BinarySeqOperation**: base abstraction for operations involving two sequences
- **Projection**: projects one sequence onto another while preserving order
- **OccursWithin**: checks whether one sequence appears contiguously within another
- **SumsOfPrefixes**: produces a sequence containing the sums of all prefixes of a given sequence

### Evaluators
- **SeqEvaluator**: abstraction for evaluating collections of sequence operations
- **ConcatAll**: concatenates the resulting sequences of compatible operations
- **FilterAll**: filters boolean results produced by compatible operations

### Exceptions
- **IllegalOperationException**: signals invalid or incompatible operations added to an evaluator



## Key Features
- Order-preserving sequence projection with duplicate handling
- Subsequence detection with correct boundary and edge-case handling
- Prefix sum generation including the empty prefix
- Support for evaluators that store and process multiple operations
- Concatenation of sequence results across multiple operations
- Filtering of boolean results with placeholder output for filtered values
- Robust handling of incompatible and invalid operations via exceptions
- Clear string representations describing both operations and results



## Testing
JUnit tests serve as the primary documentation and validation mechanism. The tests specify:
- Exact behavior of each sequence operation
- Expected string output formats
- Correct handling of empty and non-empty sequences
- Compatibility rules for evaluators
- Proper exception handling for invalid or unsupported operations



## Learning Objectives
- Infer class structure and behavior from JUnit tests
- Apply inheritance and dynamic binding to reduce code duplication
- Design abstract base classes with overridden behavior
- Implement non-trivial logic under strict programming constraints
- Strengthen understanding of reference-typed, multi-valued attributes
- Practice defensive and exception-based programming in Java


