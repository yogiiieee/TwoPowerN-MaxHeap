# TwoPowerN-MaxHeap
TwoPowerN-MaxHeap is a Java implementation of a max heap data structure where each node can have 2^n children, offering a flexible branching factor. This generic class supports efficient insertion and deletion while maintaining the max heap property.

## Table of Contents
- [Introduction](#introduction)
- [What are Heaps?](#what-are-heaps)
- [What is a Max Heap?](#what-is-a-max-heap)
- [Implementation of Heaps Using Arrays](#implementation-of-heaps-using-arrays)
- [Two to the Power N Heap](#two-to-the-power-n-heap)
- [Class Explanation](#class-explanation)

## Introduction

This project implements a generic `TwoPowerNMaxHeap` in Java. A heap is a specialized tree-based data structure that satisfies the heap property. This particular implementation allows the heap to have a variable number of children, defined as \(2^n\).

## What are Heaps?

A **heap** is a complete binary tree which satisfies the heap property. There are two types of heaps:

- **Min Heap**: The value of each node is greater than or equal to the value of its parent, with the minimum value at the root.
- **Max Heap**: The value of each node is less than or equal to the value of its parent, with the maximum value at the root.

## What is a Max Heap?

A **max heap** is a binary tree where:
- The value of each node is greater than or equal to the values of its children.
- The highest value is at the root of the tree.
- It is a complete binary tree (all levels are completely filled except possibly for the last level).

## Implementation of Heaps Using Arrays

Heaps are often implemented using arrays because this representation is space-efficient. Given a node at index `i` in the array:
- The parent of the node is at index \((i-1)/2\).
- The left child is at index \(2i + 1\).
- The right child is at index \(2i + 2\).

This structure allows for efficient insertion and deletion operations.

## Two to the Power N Heap

In a **Two to the Power N Heap**, each node can have \(2^n\) children, where `n` is a power specified by the user. This generalization of the binary heap allows for more flexible branching factors.

### Key Properties:
- **Children Count**: Each node has \(2^n\) children.
- **Parent Calculation**: For a node at index `i`, the parent is at index \((i - 1) / 2^n\).
- **Children Calculation**: For a node at index `i`, the children are at indices \((2^n \cdot i + 1)\) to \((2^n \cdot i + 2^n)\).

## Class Explanation

The `TwoPowerNMaxHeap` class is a generic implementation that supports any type that extends `Comparable`.

### Key Methods:

- **Constructor**: Initializes the heap with a specified number of children \(2^n\).
- **insert(T value)**: Adds a new value to the heap, maintaining the max heap property.
- **popMax()**: Removes and returns the maximum value from the heap.
- **heapifyUp(int index)**: Ensures the heap property is maintained after an insertion.
- **heapifyDown(int index)**: Ensures the heap property is maintained after removal.
- **printHeap()**: Prints the current state of the heap.

### How to Run

1. Compile the `TwoPowerNMaxHeap.java` file.
2. Run the `Main` class.
3. Follow the prompts to interact with the heap.

This README provides a comprehensive overview of heaps, max heaps, and the specific `TwoPowerNMaxHeap` implementation. The example code demonstrates how to use this class in a practical application.
