CREATE DATABASE IF NOT EXISTS myTest;
DROP TABLE IF EXISTS reserve_session;
DROP TABLE IF EXISTS reserve_order;
drop table if exists member;
use  myTest;


-- 查詢
SELECT reserve_order_id,reserve_session_id, member_id, reserve_order_date, reserve_number,reserve_order_state, booking_date, order_note
FROM reserve_order
order by reserve_order_id;
-- 新增
INSERT INTO reserve_order
(reserve_session_id, member_id, reserve_order_date,reserve_number, booking_date, order_note) 
VALUES  (101, 1001, '2024-03-30', 15, '2024-04-25 11:00:00', '特別要求：窗邊位置');
SELECT reserve_order_id,reserve_session_id, member_id, reserve_order_date, reserve_number,reserve_order_state, booking_date, order_note 
FROM reserve_order
where reserve_order_id = 2001;
DELETE FROM reserve_order where reserve_order_id = 2001;
UPDATE reserve_order set order_note="測試" where reserve_order_id = 2002;


-- create table member (
-- member_id int not null PRIMARY KEY
-- );
-- insert into member 
-- value(1),(2),(3),(45),(104);
-- 創建測試用會員表格
CREATE TABLE member (
    member_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    member_name VARCHAR(10) NOT NULL,
    member_account VARCHAR(10) NOT NULL UNIQUE,
    member_password VARCHAR(10) NOT NULL,
    member_email VARCHAR(50) NOT NULL UNIQUE,
    member_phone VARCHAR(10) NOT NULL,
    member_address VARCHAR(225),
    member_state TINYINT NOT NULL,
    member_gender BOOLEAN NOT NULL,
    member_birthday DATE
)AUTO_INCREMENT = 1001;
INSERT INTO member (member_name, member_account, member_password, member_email, member_phone, member_address, member_state, member_gender, member_birthday)
VALUES ( '李八七', 'john123', 'password1', 'john@example.com', '0912345678', '台北市松山區', 1, 0, '1990-01-01');
INSERT INTO member ( member_name, member_account, member_password, member_email, member_phone, member_address, member_state, member_gender, member_birthday)
VALUES ( '王大恩', 'jane456', 'password2', 'jane@example.com', '0911222333', '桃園市平鎮區', 1, 1, '1995-05-05');
INSERT INTO member ( member_name, member_account, member_password, member_email, member_phone, member_address, member_state, member_gender, member_birthday)
VALUES ( '陳小明', 'mike789', 'password3', 'mike@example.com', '0911112222', '新北式永和區', 1, 0, '1985-10-10');
INSERT INTO member ( member_name, member_account, member_password, member_email, member_phone, member_address, member_state, member_gender, member_birthday)
VALUES ( '余中天', 'yu123', 'password4', 'yu@example.com', '0900123456', '桃園市中壢區', 1, 0, '1985-11-10');
INSERT INTO member ( member_name, member_account, member_password, member_email, member_phone, member_address, member_state, member_gender, member_birthday)
VALUES ( '陳英九', 'chen789', 'password5', 'chen@example.com', '0987654321', '桃園市中壢區', 1, 0, '1985-08-10');
INSERT INTO member ( member_name, member_account, member_password, member_email, member_phone, member_address, member_state, member_gender, member_birthday)
VALUES ( '李小尛', 'lee222', 'password6', 'lee@example.com', '0930123456', '桃園市八德區', 1, 0, '1993-04-10');
INSERT INTO member ( member_name, member_account, member_password, member_email, member_phone, member_address, member_state, member_gender, member_birthday)
VALUES ( '蔡陰魂', 'chen111', 'password6', 'ch@example.com', '0909111111', '台中市大里區', 1, 1, '1998-03-10');


-- 創建餐廳場次表格 RESERVE_SESSION
CREATE TABLE reserve_session (
    reserve_session_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    reserve_max_part INT NOT NULL DEFAULT 100,
    session_time VARCHAR(20)
)AUTO_INCREMENT = 101;
-- 新增資料
INSERT INTO reserve_session(
 session_time)
values(NULL),(NULL),(NULL);
-- INSERT INTO reserve_session ( session_time)
-- VALUES ("中午"),("晚上"),("中午"),("晚上"),("中午"),("晚上");



-- 創建餐廳訂單表格 RESERVE_ORDER
CREATE TABLE reserve_order (
    reserve_order_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    reserve_session_id INT NOT NULL default 0,
    member_id INT  NOT NULL, 
    reserve_order_date DATE NOT NULL ,
    reserve_number INT NOT NULL,
    reserve_order_state TINYINT default 1,
    booking_date DATETIME NOT NULL,
    order_note VARCHAR(50),
   --  FOREIGN KEY (reserve_session_id) REFERENCES reserve_session(reserve_session_id),
    FOREIGN KEY (member_id) REFERENCES member(member_id)
)AUTO_INCREMENT = 2001;

-- 新增order資料
INSERT INTO reserve_order (reserve_session_id, member_id, reserve_order_date, reserve_number, booking_date, order_note)
VALUES
    (101, 1001, '2024-03-30', 15, '2024-04-25 11:00:00', '特別要求：窗邊位置'),
    (101, 1003, '2024-03-31', 20, '2024-04-25 12:00:00', NULL),
    (102, 1004, '2024-04-01', 6,'2024-04-28 12:30:00', NULL),
    (103, 1005, '2024-04-02', 10, '2024-04-29 16:30:00', '特殊要求：2位素食者'),
    (104, 1007, '2024-04-03', 5,'2024-05-01 18:30:00', NULL);



 SET SQL_SAFE_UPDATES  = 0;  -- 關閉安全模式

-- INSERT INTO reserve_order ( member_id, reserve_order_date, reserve_number, booking_date, order_note)
-- VALUES
--     ( 1001, '2024-03-30', 15, '2024-04-25 11:00:00', '特別要求：窗邊位置'),
--     ( 1003, '2024-03-31', 20, '2024-04-26 12:00:00', NULL),
--     ( 1004, '2024-04-01', 6,'2024-04-28 12:30:00', NULL),
--     ( 1005, '2024-04-02', 10, '2024-04-29 16:30:00', '特殊要求：2位素食者'),
--     ( 1007, '2024-04-03', 5,'2024-05-01 18:30:00', NULL);
-- ALTER TABLE reserve_order
-- ADD CONSTRAINT reserve_session_id
-- FOREIGN KEY (reserve_session_id) REFERENCES reserve_session(reserve_session_id);



-- -- 抓取ORDER時間顯示白天或是晚上
-- UPDATE RESERVE_SESSION e
-- join reserve_order r on  r.reserve_session_id =  e.reserve_session_id
-- SET e.SESSION_TIME = CASE 
--                         WHEN HOUR(r.booking_date) < 15 THEN '白天'
--                         ELSE '晚上'
--                     END
-- where r.reserve_session_id = e.reserve_session_id;
