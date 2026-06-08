-- 회의실 더미 데이터
INSERT INTO rooms (name, location, capacity, has_projector, has_whiteboard) VALUES
    ('한라', '3층 A동', 10, TRUE,  TRUE),
    ('백두', '3층 B동', 6,  FALSE, TRUE),
    ('지리', '4층 A동', 20, TRUE,  TRUE),
    ('설악', '4층 B동', 4,  FALSE, FALSE),
    ('태백', '5층 A동', 30, TRUE,  FALSE);

-- 사용자 더미 데이터
INSERT INTO users (name, email, department) VALUES
    ('김민준', 'minjun.kim@example.com',    '개발팀'),
    ('이서연', 'seoyeon.lee@example.com',   '기획팀'),
    ('박지호', 'jiho.park@example.com',     '디자인팀'),
    ('최수아', 'sua.choi@example.com',      '개발팀'),
    ('정우진', 'woojin.jung@example.com',   '마케팅팀'),
    ('강하은', 'haeun.kang@example.com',    '인사팀'),
    ('윤도현', 'dohyun.yoon@example.com',   '개발팀'),
    ('임지수', 'jisu.lim@example.com',      '기획팀');

-- 예약 더미 데이터 (오늘 기준 전후 2주)
INSERT INTO reservations (room_id, user_id, title, start_time, end_time, attendees, status) VALUES
    (1, 1, '스프린트 플래닝',        CURRENT_DATE + INTERVAL '9 hours',   CURRENT_DATE + INTERVAL '10 hours',  8,  'confirmed'),
    (2, 2, '신규 기능 기획 리뷰',    CURRENT_DATE + INTERVAL '10 hours',  CURRENT_DATE + INTERVAL '11 hours',  5,  'confirmed'),
    (3, 3, '디자인 시스템 워크샵',   CURRENT_DATE + INTERVAL '13 hours',  CURRENT_DATE + INTERVAL '15 hours',  15, 'confirmed'),
    (4, 4, '1:1 미팅',              CURRENT_DATE + INTERVAL '11 hours',  CURRENT_DATE + INTERVAL '11 hours 30 minutes', 2, 'confirmed'),
    (5, 5, '전사 마케팅 전략 회의',  CURRENT_DATE + INTERVAL '14 hours',  CURRENT_DATE + INTERVAL '16 hours',  25, 'confirmed'),
    (1, 6, 'HR 면접',               CURRENT_DATE + INTERVAL '1 day 10 hours',  CURRENT_DATE + INTERVAL '1 day 11 hours',  3, 'confirmed'),
    (2, 7, '기술 부채 논의',        CURRENT_DATE + INTERVAL '1 day 14 hours',  CURRENT_DATE + INTERVAL '1 day 15 hours',  4, 'confirmed'),
    (3, 8, '분기 OKR 점검',         CURRENT_DATE + INTERVAL '2 days 9 hours',  CURRENT_DATE + INTERVAL '2 days 11 hours', 12, 'confirmed'),
    (1, 2, '서비스 런칭 준비',       CURRENT_DATE + INTERVAL '3 days 13 hours', CURRENT_DATE + INTERVAL '3 days 14 hours', 7, 'confirmed'),
    (4, 3, '디자인 QA',             CURRENT_DATE - INTERVAL '1 day' + INTERVAL '15 hours', CURRENT_DATE - INTERVAL '1 day' + INTERVAL '16 hours', 3, 'confirmed'),
    (2, 1, '백엔드 아키텍처 논의',   CURRENT_DATE - INTERVAL '2 days' + INTERVAL '10 hours', CURRENT_DATE - INTERVAL '2 days' + INTERVAL '12 hours', 5, 'confirmed'),
    (5, 5, '전사 월간 회고',         CURRENT_DATE + INTERVAL '7 days 14 hours', CURRENT_DATE + INTERVAL '7 days 16 hours', 28, 'confirmed');
