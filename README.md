# Building Blueprint System (Java)

## Project Overview
This project implements a simplified building blueprint system in Java. The system models building units (rooms), floors with limited capacity, and an overall building blueprint composed of multiple floor plans. The required behavior, constraints, and design decisions are fully specified through JUnit test cases, which serve as the primary documentation for the system.

The project emphasizes object-oriented design, correct use of equality, and manual management of collections using primitive arrays only.

## System Components
The system is composed of the following core classes:
- Unit: represents a room or functional space with a purpose and dimensions
- Floor: represents a building floor with a fixed maximum capacity measured in square feet
- Blueprint: represents the blueprint of a multi-floor building
- InsufficientFloorSpaceException: signals attempts to exceed a floor’s capacity



## Key Features
- Unit area calculation based on width and length
- Support for toggling measurements between feet and meters
- Custom string representations describing dimensions and area
- Equality comparison for units based on function and area (not dimensions)
- Floor capacity tracking with remaining space calculation
- Controlled addition of units to floors with exception handling
- Floor equality based on capacity and utilization (independent of unit order)
- Building blueprint progress tracking as a percentage of completed floor plans
- Deep-copy behavior to preserve composition when retrieving floors



## Testing
All functionality is validated using JUnit tests. The tests define:
- Correct construction and string output of units, floors, and blueprints
- Measurement conversion accuracy and formatting requirements
- Capacity enforcement and exception behavior
- Proper implementation of equals methods
- Order-independent comparisons of floor utilization
- Preservation of composition through defensive copying


