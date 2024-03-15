package com.openclassrooms.starterjwt.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.starterjwt.models.Session;
import com.openclassrooms.starterjwt.models.Teacher;
import com.openclassrooms.starterjwt.models.User;
import com.openclassrooms.starterjwt.repository.SessionRepository;
import com.openclassrooms.starterjwt.repository.UserRepository;
@SpringBootTest
public class SessionServiceTest {
	
@Mock	
private UserRepository userRepository;

@Mock
private SessionRepository sessionRepository;

@InjectMocks
private SessionService sessionService;

private static Session session;

@BeforeAll
static void setUp() {
	new User(1L,"test@test.com","lastName","FirstName","MotDePasse1234",false,LocalDateTime.now(),null);
	Teacher teacher =new Teacher(1L,"FirstName","MotDePasse1234",LocalDateTime.now(),null);
	session = new Session(1L,"sessionName",new Date(),"sessiondesc",teacher,new ArrayList<>(),LocalDateTime.now(),null);
}

//create Session
@Test
void createReturnsSession() {
	Session sessionToCreateUnderTest = session;
	when(sessionRepository.save(sessionToCreateUnderTest))
    .thenReturn(sessionToCreateUnderTest);
  // Act
  Session createdSession = sessionService.create(sessionToCreateUnderTest);
  // Assert
  verify(sessionRepository).save(sessionToCreateUnderTest);
  assertThat(createdSession).isEqualTo(sessionToCreateUnderTest);
}

//Get By Id Session
@Test
void getByIdSession() {
	 //assertThat(1).isEqualTo(2);	
	Long testSessionIdUnderTest = 1L;
    Session sessionUnderTest = session;
    when(sessionRepository.findById(testSessionIdUnderTest))
      .thenReturn(Optional.of(sessionUnderTest));
    Session retrievedSession = sessionService.getById(testSessionIdUnderTest);
    verify(sessionRepository).findById(testSessionIdUnderTest);
    assertThat(retrievedSession).isEqualTo(sessionUnderTest);
}

//update Session
@Test
void updateSession() {
	Long testSessionIdUnderTest = 2L;
    Session updatedSessionUnderTest = session;
    when(sessionRepository.save(updatedSessionUnderTest))
      .thenReturn(updatedSessionUnderTest);
    Session result = sessionService.update(
      testSessionIdUnderTest,
      updatedSessionUnderTest
    );
    verify(sessionRepository).save(updatedSessionUnderTest);
    assertThat(result).isEqualTo(updatedSessionUnderTest);
    assertThat(result.getId()).isEqualTo(2L);
}

//delete
@Test
void deleteSession() {
    Long testSessionIdUnderTest = 1L;
    sessionService.delete(testSessionIdUnderTest);
    verify(sessionRepository).deleteById(testSessionIdUnderTest);
}

}
