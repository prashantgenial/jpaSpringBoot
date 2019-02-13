Make sure all @OneToOne or @ManyToOne properties marked as LAZY fetch
@OneToOne(fetch=FetchType.LAZY)
	private Role role;
	
this will make sure that other table data did not fetch by default.

create User Section
@ManyTOMany
@JoinTable(
joinColumns=@JoinColumn(),inverseJoinColumns=@JoinColumn()
)

add
@ManyToMany(mappedBy="courses")

TODO:
paging
search by email
search by name
search by rolename

##URL
localhost:8080/search
localhost:8080/search?sort=name,desc