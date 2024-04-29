package com.example.garpinator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecordsXMLParser {

    private static final String ns = null;

    public static List<String> parseRecords(Context context,int xmlFile) {
        List<String> records = new ArrayList<>();
        Resources res = context.getResources();
        XmlResourceParser parser = res.getXml(xmlFile);
        try {
            while (parser.next() != XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG && !parser.getName().equals("record") && !parser.getName().equals("records")) {
                    records.add(parser.nextText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
}
