package com.movievoting.movieVoting.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "AllGroups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;
    private String Name;
    private String inviteCode;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User createdBy;
    @OneToMany(mappedBy = "group")
    private List<Movie> movies=new ArrayList<Movie>();
   @ManyToMany(cascade = CascadeType.REMOVE)
   @JoinTable(name = "group_members",joinColumns = @JoinColumn(name="groupId"),inverseJoinColumns = @JoinColumn(name="userId"))
   private Set<User> members=new HashSet<>();
}
