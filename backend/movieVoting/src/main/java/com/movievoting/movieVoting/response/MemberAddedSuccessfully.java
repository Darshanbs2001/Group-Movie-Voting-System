package com.movievoting.movieVoting.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberAddedSuccessfully {
 int userId;
 String name;
 String GroupName;
 String msg;
 
}
