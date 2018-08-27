insert into member_role(id,name) values (1,'ROLE_USER');
insert into member_role(id,name) values (2,'ROLE_ADMIN');

insert into member ( id, name, email, password, join_date ) values (1, 'kim', 'kimhk0@naver.com', '{bcrypt}$2a$10$k9wa8jrdyjJoinn8MuiYTuG8ATaKZotw/psmuntgWW4GyGDkpKPm6', now());
insert into member ( id, name, email, password, join_date ) values (2, 'lee', 'lee0@naver.com', '{bcrypt}$2a$10$k9wa8jrdyjJoinn8MuiYTuG8ATaKZotw/psmuntgWW4GyGDkpKPm6', now());

insert into member_member_role(member_id,member_role_id) values (1,1);
insert into member_member_role(member_id,member_role_id) values (2,2);

insert into board_category(id,name) values (1,'java');
insert into board_category(id,name) values (2,'free');

insert into board(id, member_id, board_category_id, title, content, read_count, create_date, update_date)
values(1, 1, 2, 'title1', 'hello 1111111111', 2, now(), now());

insert into board(id, member_id, board_category_id, title, content, read_count, create_date, update_date)
values(2, 1, 2, 'title2', 'hello 2222222222', 5, now(), now());

insert into board(id, member_id, board_category_id, title, content, read_count, create_date, update_date)
values(3, 2, 2, 'title3', 'hello 3333333333', 200, now(), now());

insert into board_file( id, board_id, mime_type, name, save_file_name, size)
values(1, 1, 'image/jpg', 'a.jpg', 'tmp/a.jpg', 100);

insert into board_file( id, board_id, mime_type, name, save_file_name, size)
values(2, 1, 'image/jpg', 'b.jpg', 'tmp/b.jpg', 100);

insert into board_file( id, board_id, mime_type, name, save_file_name, size)
values(3, 2, 'image/jpg', 'c.jpg', 'tmp/c.jpg', 100);

insert into board_file( id, board_id, mime_type, name, save_file_name, size)
values(4, 2, 'image/jpg', 'd.jpg', 'tmp/d.jpg', 100);

