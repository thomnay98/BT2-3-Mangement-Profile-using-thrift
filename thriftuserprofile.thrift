namespace java thriftuserprofile

struct User {
    1: i32 id,
    2: string name,
    3: string email,
    4: string password,
    5: string address,
    6: string phone
}

exception InvalidOperation {
  1: i32 what,
  2: string why
}

exception StatusError {
  1: i32 errCode,
  2: string errMessage,
  3: User user
}

service UserService {
    bool registerUser(1: User user) throws (1: InvalidOperation ouch),
    User loginUser(1: string email, 2: string password) throws (1: InvalidOperation ouch),
    bool deleteUser(1: string Email) throws (1: InvalidOperation ouch)
}