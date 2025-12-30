# Vaccination Tracker System

## Project Overview
This project implements a simplified vaccination tracking system in Java. The system models vaccines, their distributions, vaccination sites, patient health records, and appointment management. The design and behavior of the system are entirely specified through JUnit test cases, which act as the primary documentation for how the system should operate.

The implementation emphasizes object-oriented design and manual data management without relying on Java collection libraries.

## System Components
The project includes the following core model classes:
- Vaccine: represents a vaccine, including its codename, type, manufacturer, and recognition status in Canada
- VaccineDistribution: represents a quantity of a specific vaccine supplied to a vaccination site
- VaccinationSite: manages vaccine supply, appointment booking, and administration of doses
- HealthRecord: tracks a patient’s vaccination history and appointment status
- Custom exception classes are used to handle invalid operations such as unrecognized vaccines, excessive distributions, and insufficient doses.

## Key Features
- Identification of recognized and unrecognized vaccines based on codename
- Tracking of vaccine distributions and total available doses at vaccination sites
- Per-vaccine supply tracking with preservation of distribution order
- Appointment booking with capacity constraints
- Vaccine administration that updates both site inventory and patient health records
- Support for multiple vaccination sites and multi-dose vaccination histories



## Testing
All functionality is validated using JUnit tests. The tests define:
- Expected object construction and string representations
- Correct handling of recognized vs unrecognized vaccines
- Vaccine distribution limits and ordering rules
- Appointment booking success and failure conditions



## Learning Objectives
- Practice object-oriented design under strict constraints
- Infer class structure and behavior from test cases
- Manually manage collections using arrays
- Trace object interactions across multiple collaborating classes
- Understand exception-driven control flow in Java


