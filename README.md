# Assignment #4 — Facade Pattern

## Project
Smart Home Automation System

## Description
This project implements the Facade structural design pattern in Java

The system contains five independent subsystems:
- LightingSystem
- ClimateControlSystem
- SecuritySystem
- SmartLockSystem
- EnergyManagementSystem

SmartHomeFacade provides a simplified API for activating common home routines

## Available Operations
- activateHomeMode()
- activateAwayMode()
- activateNightMode()
- activateEnergySavingMode()

## Design Pattern
The client interacts only with SmartHomeFacade
The facade coordinates subsystem operations in the correct order
Subsystem classes do not depend on the facade and can be used independently

## Clean Code Principles
1. Meaningful names: methods describe their purpose
2. Single Responsibility Principle: each subsystem handles one area
3. Encapsulation: the facade hides subsystem coordination details
4. Small classes: each subsystem has a focused responsibility
5. Input validation: brightness and temperature values are validated
6. Error handling: failed routines provide contextual exceptions
7. Dependency Injection: subsystem objects are passed to the facade through its constructor

## Technologies
- Java 17+
- IntelliJ IDEA
- No external libraries
