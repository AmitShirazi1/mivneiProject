# Mondial Tournament Simulation in JAVA

## Overview

This project is a comprehensive simulation of a football tournament implemented in Java. The project leverages advanced data structures and algorithms to handle a complex hierarchy of players, teams, and tournament matches. Emphasis is placed on custom data structures designed to support efficient querying, organization, and manipulation of tournament data. This simulation allows for detailed tracking of player statistics, team rosters, tournament progress, and more.

## Key Features

1. **Custom Data Structures**: The project implements unique data structures, specifically designed to accommodate the hierarchy and data management needs of a soccer tournament. These data structures include:
   - **FacultyTree** (1-key and 2-key variants): A specialized tree structure for storing team and player information.
   - **TwoThreeTree** (1-key and 2-key variants): A balanced tree that supports efficient searching and insertion for tournament data.

2. **Modular Design**: The project is broken down into separate modules, each handling specific aspects of the tournament simulation, such as team management, player data, and match statistics.

3. **Efficient Algorithms**: Custom algorithms for insertion, deletion, searching, and sorting, designed to work efficiently within the custom data structures. 

## File Structure

- **`Faculty.java`**: Defines the `Faculty` class, representing a team with associated players. This class manages attributes such as team name, unique ID, and a list of players. The `Faculty` class interacts with the `FacultyNode` and `FacultyTree` classes to organize teams within the tournament.

- **`FacultyNode.java`**: Represents a node in the `FacultyTree1Key` structure, storing information about individual teams and serving as the fundamental building block of the 1-key faculty tree.

- **`FacultyNode2Key.java`**: Represents a node in the `FacultyTree2Key` structure, similar to `FacultyNode` but adapted for a 2-key search system, allowing for queries by both team name and ID.

- **`FacultyTree1Key.java`**: Implements a 1-key `FacultyTree` structure, enabling efficient organization and querying of teams based on a single attribute (e.g., team name or ID).

- **`FacultyTree2Key.java`**: Extends `FacultyTree1Key` with a 2-key search capability, allowing searches based on two distinct keys. This improves flexibility in organizing and accessing tournament teams by various criteria.

- **`Main.java`**: Serves as the main entry point for running the simulation. This file initializes tournament data, populates the `FacultyTree` and `PlayerTree` structures, and simulates tournament progression by managing match results and rankings.

- **`Player.java`**: Defines the `Player` class, with attributes for player-specific information such as name, position, statistics, and team affiliation. This class integrates closely with `PlayerNode` and `PlayerTree` classes to track and manage individual player records throughout the tournament.

- **`PlayerNode.java`**: Represents a node in the `PlayerTree1Key` structure, storing individual player details within a 1-key system focused on the player’s name or ID for efficient single-attribute searches.

- **`PlayerNode2Key.java`**: Represents a node in the `PlayerTree2Key` structure, extending `PlayerNode` for a 2-key system to enable flexible querying by multiple player attributes, such as name and team.

- **`PlayerTree1Key.java`**: Implements a 1-key `PlayerTree` structure, designed to efficiently manage player records based on a single key, supporting rapid access to player information.

- **`PlayerTree2Key.java`**: Extends `PlayerTree1Key` with a 2-key search capability, offering additional flexibility in retrieving player data based on multiple attributes.

- **`TechnionTournament.java`**: Manages the overall tournament structure and operations, utilizing the custom faculty and player tree structures to simulate matches, record results, and rank teams and players based on performance.

- **`Tournament.java`**: Defines core tournament attributes and settings, including match scheduling, point allocation, and team qualification criteria. This class works in conjunction with `TechnionTournament.java` to provide a realistic tournament experience.

- **`TreeNode.java`**: Serves as a generic tree node class, encapsulating basic attributes and methods that are extended by specific node classes in the project, such as `PlayerNode` and `FacultyNode`.

- **`TreeNode1Key.java`**: Extends `TreeNode` to include functionality specific to 1-key searches, forming the backbone of the 1-key tree structures.

- **`TwoThreeTree1Key.java`**: Implements a balanced 2-3 tree structure using a 1-key system. This balanced tree structure allows efficient insertion and querying operations for the tournament.

- **`TwoThreeTree2Key.java`**: Extends `TwoThreeTree1Key` with a 2-key system, enabling multi-attribute queries, making it particularly useful for organizing and accessing tournament data by complex criteria.

- **`treeNode2keys.java`**: A general-purpose node implementation for 2-key trees, used in conjunction with other 2-key classes to provide flexibility and scalability within the tournament’s custom data structures.

## Custom Data Structures

The project centers on **FacultyTree** and **PlayerTree** data structures, which use 1-key and 2-key variations to balance data organization efficiency and query flexibility. These custom trees were designed with the following objectives:

1. **Efficient Data Access**: By using the 1-key and 2-key variations, the trees allow for fast retrieval of information based on both primary and secondary attributes, such as player/team names, IDs, and other criteria.

2. **Dynamic Insertion and Deletion**: Nodes in the `FacultyTree` and `PlayerTree` structures can be added or removed dynamically, allowing the simulation to handle updates as the tournament progresses.

3. **Balanced Tree Properties**: Using 2-3 trees and 2-key configurations, the project ensures that tree height is minimized, improving performance for larger datasets.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher.

### Compiling the Project

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Compile all Java files:
   ```bash
   javac *.java
   ```

### Running the Simulation

After compilation, execute the following command to run the simulation:

```bash
java Main
```

This will initialize the tournament, populate teams and players, and proceed with match simulations based on the configurations in `TechnionTournament.java` and `Tournament.java`.

## Usage and Customization

- **Adding Teams and Players**: To add custom teams and players, modify the initialization sections in `Main.java`.
- **Customizing Tournament Rules**: Adjust tournament settings, point allocation, and ranking criteria in `TechnionTournament.java` and `Tournament.java`.
- **Data Structures**: Experiment with different keys for `FacultyTree` and `PlayerTree` to optimize query and sorting operations for various tournament aspects.

## Conclusion

This project demonstrates advanced use of custom data structures and algorithms to create a high-performance, flexible simulation of a soccer tournament. By leveraging 1-key and 2-key tree structures, the project achieves efficient data management and complex querying, making it an ideal tool for organizing and analyzing hierarchical sports data.
