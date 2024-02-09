# jSSLPDAG
A Simple Java program that calculates the Single Source Longest Path  of a Directed Acyclic Graph.

## Overview

This Java program demonstrates the implementation of Dijkstra's algorithm for finding the longest and shortest paths in a graph. 
The algorithm is applied to a sample graph represented by vertices and edges, and it uses a custom `Graph` class to encapsulate the logic.
To find the longest path, a simple procedure where the costs of each edge is multiplied by -1 and reversed once the shortest paths are found using Dijkstra.
The graph class is used to make a "Directed Acyclic Graph", or "DAG", but it does not enforce this.

## Classes

### 1. Vertex

Represents a graph vertex with a unique identifier.

### 2. Edge

Defines an edge between two vertices with an associated cost.

### 3. Graph

Contains the main logic for Dijkstra's algorithm. It includes methods for finding both the longest and shortest paths using Dijkstra's approach.

### 4. Main

The main class showcasing the usage of the `Graph` class on a sample graph.

## How to Use

1. **Define Vertices and Edges:**
   - Create instances of the `Vertex` and `Edge` classes to represent the graph structure.

2. **Create a Graph:**
   - Instantiate the `Graph` class with the defined vertices and edges.

3. **Run Dijkstra's Algorithm:**
   - Call the `longestPath` or `dijkstra` method on the `Graph` instance to find the longest or shortest paths, respectively.

4. **Print Results:**
   - Print the results to the console or use them as needed.

