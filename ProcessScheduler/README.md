<h1>Process Scheduling Analyzer</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Powered_by-GTK_GUI-green?style=for-the-badge&logo=gtk" alt="Powered by Gtk GUI">
  <img src="https://img.shields.io/badge/Language-C-blue?style=for-the-badge&logo=c" alt="C Language">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/OS-Scheduling_Algorithms-orange?style=for-the-badge&logo=linux" alt="OS Scheduling Algorithms">
</p>

## Overview

The OS Process Scheduling Analyzer is a comprehensive tool designed to evaluate and compare the performance of various fundamental process scheduling algorithms. This tool allows users to simulate processes with different burst times, priorities, and quantum times. The supported algorithms are:

- First-Come-First-Serve (FCFS)
- Shortest Job First (SJF)
- Round Robin
- Longest Job First (LJF)
- Lottery Ticketing
- Priority Scheduling

By executing these scheduling algorithms and tracking key metrics (average waiting time, turnaround time, response time), the tool enables in-depth analysis and informed decision-making regarding process scheduling.

## Features

- **Multiple Scheduling Algorithms**: Supports FCFS, SJF, Round Robin, LJF, Priority, and Lottery Ticketing.
- **Dynamic Input**: Allows input of various process burst times, arrival times, and priorities.
- **Performance Metrics**: Calculates average waiting time, turnaround time, and response time for comparison.
- **User-Friendly Interface**: Built with a clean and simple GUI using Gtk.

## Setup and Installation

### Prerequisites

Ensure that you have the following installed on your machine:

- GCC Compiler
- GTK 3.0+ (for GUI support)

### Clone the Repository

