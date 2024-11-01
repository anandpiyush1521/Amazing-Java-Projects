# Cricket Information System

## Overview
The Cricket Information System is a comprehensive platform that provides users with information on cricket matches, teams, players, and live scores. Built for scalability and extensibility, the system ensures real-time updates, supports concurrent user access, and maintains data consistency. It is inspired by platforms like CricInfo.

## Features

1. **Match Information**: Provides details of scheduled, live, and completed matches, including venue and start times.
2. **Teams and Players**: Displays team details and player profiles, including roles and statistics.
3. **Live Scores**: Offers real-time score updates to keep users informed on ongoing matches.
4. **Scorecard and Statistics**: Shows detailed scorecards, commentary, and statistics for each match, with insights down to each innings, over, and ball.
5. **Match Schedule and Results**: Users can view upcoming match schedules and past match results.
6. **Search Functionality**: Allows users to search for specific matches, teams, or players.
7. **Concurrent Data Access**: Designed to handle multiple users accessing match data simultaneously while ensuring data integrity.
8. **Scalability and Extensibility**: Built to handle high traffic volumes and can be easily expanded with new features.


## Classes, Interfaces, and Enumerations

1. **Match**: Represents a cricket match with properties such as ID, title, venue, start time, teams, status, and scorecard.
2. **Team**: Represents a cricket team with properties like team ID, name, and a list of players.
3. **Player**: Represents a player with properties such as ID, name, and role (e.g., batsman, bowler).
4. **Scorecard**: Contains details of the match scorecard, including team scores and innings details.
5. **Innings**: Represents an innings in a match, with properties like batting team, bowling team, and overs.
6. **Over**: Represents an over in an innings, containing a list of balls.
7. **Ball**: Represents each ball bowled in an over, including the ball number, bowler, batsman, and result.
8. **MatchStatus**: An enumeration for match statuses, such as scheduled, in-progress, completed, or abandoned.
9. **MatchService**: Manages matches in the system, offering methods to add, retrieve, and update match information. It follows the Singleton pattern to ensure a single instance.
10. **ScorecardService**: Manages scorecards, allowing for creation, retrieval, and updates of scorecards and associated data. Also follows the Singleton pattern.
11. **CricinfoSystem**: The main class that integrates the match and scorecard services and provides high-level methods for interacting with the system.


This project serves as a foundation for a cricket information platform. It can be expanded with features like user accounts, push notifications for live updates, and advanced analytics for cricket fans.
