
public class Main {
public static void main(String[] args) {
	
	@Test
public void givenWaitressInstance_whenCheckedType_thenIsInstanceOfPerson() {
    assertThat(new Waitress("Mary", "mary@domain.com", 22))
      .isInstanceOf(Person.class);
}
    
@Test
public void givenActressInstance_whenCheckedType_thenIsInstanceOfPerson() {
    assertThat(new Actress("Susan", "susan@domain.com", 30))
      .isInstanceOf(Person.class);
}}
}
