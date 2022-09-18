package com.solo.learning.cint;

import java.util.Map;

class Parse {
  String title;
  Long pageid;
  Map<String, String> text;

  Parse() {}

  Parse(String title, Long pageid, Map<String, String> text) {
    this.title = title;
    this.pageid = pageid;
    this.text = text;
  }
}
