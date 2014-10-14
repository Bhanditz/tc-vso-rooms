import jetbrains.buildServer.BaseTestCase;
import jetbrains.buildServer.vsoRooms.rest.TeamRoomMessage;
import jetbrains.buildServer.vsoRooms.rest.VSOTeamRoomsAPI;
import org.testng.annotations.Test;

public class SimpleTest extends BaseTestCase {
  @Test
  public void testSendMessage() {
    final TeamRoomMessage message = VSOTeamRoomsAPI.createConnection("ekoshkin", "R42apfoo").sendMessageToRoom("ekoshkin", 11141L, "hello!");
    assertNotNull(message);
    assertEquals("hello!", message.getContent());
  }

  @Test
  public void testGetListOfRooms() {
    assertNotEmpty(VSOTeamRoomsAPI.createConnection("ekoshkin", "R42apfoo").getListOfRooms("ekoshkin"));
  }
}
