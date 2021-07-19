class Configuration {

  //APP CONFIGURATION
  static String APP_VERSION = "0.1";
  static String SERVER_URL = "http://138.68.114.109:49785/";

  //ENDPOINT
  static String HELLO = SERVER_URL + "hello";
  static String SIGNUP_USER = SERVER_URL + "user";
  static String LOGIN = SERVER_URL + "login?username=%s&password=%s";
  static String GET_ACTIVE_EVENTS = SERVER_URL + "events";
  static String GET_USER_EVENTS = SERVER_URL + "user/events";
  static String SIGN_TO_EVENT = SERVER_URL + "join/%s";
  static String UNJOIN_EVENT = SERVER_URL + "unjoin/%s";
  static String CREATE_EVENT = SERVER_URL + "event";
  static String GET_EVENT_DETAILS = SERVER_URL + "event/%s";
  static String CANCEL_EVENT = SERVER_URL + "event/%s";
}