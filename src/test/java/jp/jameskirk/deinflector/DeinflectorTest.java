/*
 * Copyright (C) 2016 James Kirk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.jameskirk.deinflector;

import org.junit.AfterClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author James Kirk
 */
public class DeinflectorTest {

    //TODO: Other Godan endings ぐ、ぬ、etc.
    //TODO: Kanji for いく、とう、こう (inc. variations)
    //TODO: Make more modular？

    private static int totalDeinflections = 0;

    @Test
    public void adjectiveTwoChar() {
        testDeinflections("美しい",
                "美しく", "美しさ", "美しかった", "美しくありませんでした", "美しくありません",
                "美しかったら", "美しかったり", "美しかった", "美しくない", "美しすぎる",
                "美しければ", "美しくて", "美しそう"
        );
    }
    
    @Test
    public void adjectiveOneChar() {
        testDeinflections("軽い",
                "軽く", "軽さ", "軽かった", "軽くありませんでした", "軽くありません",
                "軽かったら", "軽かったり", "軽かった", "軽くない", "軽すぎる",
                "軽ければ", "軽くて", "軽そう"
        );
    }

    @Test
    public void suru() {
        testDeinflections("する",
                "しませんでした", "しません", "しましょう", "しました", "します",
                "しちゃう", "しすぎる", "しなさい", "したら", "したり",
                "させる", "される", "しそう",
                "したい", "しない", "すれば", "しよう", "せず",
                "して", "した", "しなかった",
                "しなければ", "させられる", "させられた",
                "したければ", "したくなかった", "したい", "したかった"
        );
    }
    
    @Test
    public void kuruHiragana() {
        testDeinflections("くる",
                "きませんでした", "きません", "きましょう", "きました", "きます",
                "きちゃう", "きすぎる", "きなさい", "きたら", "きたり",
                "こさせる", "こられる", "きそう",
                "きたい", "こない", "くれば", "こよう", "こず",
                "きて", "きた", "こなかった",
                "こなければ", "こさせられる", "こさせられた",
                "きたければ", "きたくなかった", "きたい", "きたかった"
        );
    }    
    
    @Test
    public void kuruKanji() {
        testDeinflections("来る",
                "来ませんでした", "来ません", "来ましょう", "来ました", "来ます",
                "来ちゃう", "来すぎる", "来なさい", "来たら", "来たり",
                "来させる", "来られる", "来そう",
                "来たい", "来ない", "来れば", "来よう", "来ず",
                "来て", "来た", "来なかった",
                "来なければ", "来させられる", "来させられた",
                "来たければ", "来たくなかった", "来たい", "来たかった"
        );
    }

    @Test
    public void iku() {
        testDeinflections("いく",
                "いっちゃう", "いったら", "いったり",
                "いって", "いった"
        );
    }

    @Test
    public void tou() {
        testDeinflections("とう",
                "とうて", "とうた" //TODO: とうたり, etc.?
        );
    }

    @Test
    public void kou() {
        testDeinflections("こう",
                "こうて", "こうた" //TODO: こうたり, etc.?
        );
    }

    @Test
    public void kureru() {
        //TODO
    }

    @Test
    public void aru() {
        //TODO
        System.out.println(Deinflector.deinflect("聞かれました"));
    }

    @Test
    public void irassharu() {
        //TODO
    }

    @Test
    public void godanKuVerb() {
        testDeinflections("聞く",
                "聞きませんでした", "聞きません", "聞きましょう", "聞きました", "聞きます",
                "聞いちゃう", "聞きすぎる", "聞きなさい", "聞いたら", "聞いたり",
                "聞かせる", "聞ける", "聞かれる", "聞きそう",
                "聞かない", "聞けば", "聞こう", "聞かず", "聞け", "聞き",
                "聞いて", "聞いた", "聞かなかった", "聞けた",
                "聞かなければ", "聞かせられる", "聞かせられた",
                "聞きたければ", "聞きたくなかった", "聞きたい", "聞きたかった"
        );
    }

    @Test
    public void godanSuVerb() {
        testDeinflections("下す",
                "下しませんでした", "下しません", "下しましょう", "下しました", "下します",
                "下しちゃう", "下しすぎる", "下しなさい", "下したら", "下したり",
                "下させる", "下せる", "下される", "下しそう",
                "下したい", "下さない", "下せば", "下そう", "下さず", "下せ", "下し",
                "下して", "下した", "下さなかった", "下せた",
                "下さなければ", "下させられる", "下させられた",
                "下したければ", "下したくなかった", "下したい", "下したかった");
    }

    @Test
    public void ichidanVerb() {
        testDeinflections("食べる",
                "食べませんでした", "食べません", "食べましょう", "食べました", "食べます",
                "食べちゃう", "食べすぎる", "食べなさい", "食べたら", "食べたり",
                "食べさせる", "食べられる", "食べれる", "食べそう",
                "食べたい", "食べない", "食べれば", "食べよう", "食べず", "食べろ", "食べ",
                "食べて", "食べた", "食べなかった", "食べたい", "食べたかった",
                "食べられた", "食べれた",
                "食べたくなかった",
                "食べなければ", "食べたければ", "食べさせられる", "食べさせられた"
        );
    }

    @AfterClass
    public static void tearDown() throws Exception {
        System.out.printf("Total deinflections: %d", totalDeinflections);
    }

    private static void testDeinflections(String base, String... inflections) {
        for (String inflection : inflections) {

            final List<Deinflection> deinflections = Deinflector.deinflect(inflection);

            boolean contains = false;
            int count = 0;
            for (Deinflection deinflection : deinflections) {
                count++;
                if (deinflection.getBaseForm().equals(base))
                    contains = true;
            }

            totalDeinflections += count;

            System.out.printf("%s [%d]:\t\t\t\t%s%n", inflection, count, deinflections);
            assertTrue(inflection + " should deinflect to " + base + ", but only got " + deinflections, contains);
        }
    }
}