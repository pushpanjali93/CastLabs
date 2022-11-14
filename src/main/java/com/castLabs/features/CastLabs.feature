Feature: verify the HLS-HLS Clear

  Scenario Outline:check the HLS - HLS Clear
    Given navigate the page
    When Play HLS - HLS Clear by clicking on the stream
    Then The browser opens with the details of the video
    And Seek to <percent> of the video duration
    Then Validate the Player state change in the console logs
    And Click the options button three dots and click Videos
    Then Select any video value 1280x720 and Validate the selection
    Examples:
      | percent |
      | 70      |