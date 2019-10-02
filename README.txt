REST API
GET: /
    -showing user posts
GET: /followed
    -showing followed users posts
POST: /post/post
    -adding post to current user (and if does not exists creating new user by new JSESSIONID)
POST: /user/follow
    -adding followed user to current user


for example to start we have to add new post and creating new user, this process will be automaticly
after sending POST command we have to copy JSESSIONID from Header response and use this in feature requests
now we can send other commands like (GET:/ or POST another post) of course with copied Cookie: JSESSIONID=.... in the Header

after when we have some posts we can register new user by sending POST:/post/post without or different than before JSESSIONID
and using this new JSESSIONID we can follow this user by first user by POST:/user/follow command with followUser command with user prefix
for example
userE49D86D2D772E2EF2A488CD07121BEF1

and now using POST:/user/follow with JSESSIONID from first user we can see posts from followed users