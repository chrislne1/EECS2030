# Channel–Follower Video Platform

## Project Overview
This project implements a simplified video-sharing platform inspired by subscription-based content systems. The system models channels that release videos, followers who subscribe to channels, and two distinct follower types with different behaviors: subscribers and monitors.

All required behavior, constraints, and object interactions are fully specified through JUnit tests, which act as executable documentation for the system.



## System Components

### Channels
- **Channel**
  - Releases videos with unique names
  - Maintains a list of followers
  - Notifies subscribers when new videos are released
  - Updates monitors with viewing statistics when videos are watched

### Followers
- **Follower** (abstract)
  - Common abstraction for all followers
  - Tracks followed channels
- **Subscriber**
  - Receives video recommendations from followed channels
  - Can watch recommended videos
- **Monitor**
  - Tracks viewing statistics for channels it follows
  - Maintains per-channel statistics such as:
    - Number of views
    - Maximum watch time
    - Average watch time (formatted to two decimal places)



## Key Features
- Bidirectional follow and unfollow relationships between channels and followers
- Order-preserving lists of followers, channels, and videos
- Video recommendation logic limited to subscribers only
- No retroactive recommendations for videos released before following
- Real-time update of monitor statistics when subscribers watch videos
- Independent statistics tracking per monitor, based on follow time
- Accurate tracking of:
  - View count
  - Maximum watch duration
  - Average watch duration
- Strictly formatted string outputs define


