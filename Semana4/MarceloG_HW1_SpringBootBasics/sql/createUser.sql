drop user if exists 'restcrudapi'@'%';
create user 'restcrudapi'@'%' identified by '12345';
grant all privileges on *.* to 'restcrudapi'@'%';