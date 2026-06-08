-- 회의실
CREATE TABLE IF NOT EXISTS rooms (
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    location    VARCHAR(100) NOT NULL,
    capacity    INT NOT NULL,
    has_projector BOOLEAN DEFAULT FALSE,
    has_whiteboard BOOLEAN DEFAULT FALSE,
    created_at  TIMESTAMP DEFAULT NOW()
);

-- 사용자
CREATE TABLE IF NOT EXISTS users (
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    email       VARCHAR(200) UNIQUE NOT NULL,
    department  VARCHAR(100),
    created_at  TIMESTAMP DEFAULT NOW()
);

-- 예약
CREATE TABLE IF NOT EXISTS reservations (
    id          SERIAL PRIMARY KEY,
    room_id     INT NOT NULL REFERENCES rooms(id),
    user_id     INT NOT NULL REFERENCES users(id),
    title       VARCHAR(200) NOT NULL,
    start_time  TIMESTAMP NOT NULL,
    end_time    TIMESTAMP NOT NULL,
    attendees   INT DEFAULT 1,
    status      VARCHAR(20) DEFAULT 'confirmed',
    created_at  TIMESTAMP DEFAULT NOW(),
    CONSTRAINT no_overlap EXCLUDE USING gist (
        room_id WITH =,
        tsrange(start_time, end_time) WITH &&
    )
);
