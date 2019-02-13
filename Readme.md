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
Sorting [done]
paging[done]
search by email
search by name
search by rolename

##URL
localhost:8080/search
localhost:8080/search?sort=name,desc
localhost:8080/search?sort=name,asc&page=0&size=1
PagedListHolder
PageImpl

https://www.baeldung.com/rest-api-query-search-language-more-operations
http://localhost:8080/users?search=firstName:jo*,age<25
localhost:8080/user/search?search=role:Admin,name~pras
We have two sets of operations:

1. Simple – can be represented by one character:

Equality: represented by colon (:)
Negation: represented by Exclamation mark (!)
Greater than: represented by (>)
Less than: represented by (<)
Like: represented by tilde (~)
2. Complex – need more than one character to be represented:

Starts with: represented by (=prefix*)
Ends with: represented by (=*suffix)
Contains: represented by (=*substring*)

