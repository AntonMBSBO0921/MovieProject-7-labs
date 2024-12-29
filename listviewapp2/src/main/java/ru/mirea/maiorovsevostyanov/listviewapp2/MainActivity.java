package ru.mirea.maiorovsevostyanov.listviewapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView eventListView = findViewById(R.id.eventListView);
        List<HistoricalEvent> events = getHistoricalEvents();
        EventAdapter adapter = new EventAdapter(events, getLayoutInflater());
        eventListView.setAdapter(adapter);
    }

    private List<HistoricalEvent> getHistoricalEvents() {
        List<HistoricalEvent> events = new ArrayList<>();

        events.add(new HistoricalEvent(
                "Первый полет человека в космос",
                "Юрий Гагарин стал первым человеком в космосе на корабле Восток-1",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "12 апреля 1961"
        ));

        events.add(new HistoricalEvent(
                "Основание Москвы",
                "Первое летописное упоминание Москвы князем Юрием Долгоруким",
                "https://avatars.dzeninfra.ru/get-zen_doc/1917356/pub_64c23ed03fc50007bd1ed030_64c240199287af0155a80334/scale_1200",
                "1147 год"
        ));

        events.add(new HistoricalEvent(
                "Отечественная война",
                "Победа России над армией Наполеона",
                "https://news.store.rambler.ru/img/041af9979f271521e5742204dcd79399?img-format=auto&img-1-resize=height:400,fit:max&img-2-filter=sharpen",
                "1812 год"
        ));

        events.add(new HistoricalEvent(
                "Крещение Руси",
                "Массовое крещение жителей Киева в водах Днепра князем Владимиром",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "988 год"
        ));

        events.add(new HistoricalEvent(
                "Куликовская битва",
                "Сражение русских полков во главе с великим князем Дмитрием Донским против войск Золотой Орды",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "8 сентября 1380"
        ));

        events.add(new HistoricalEvent(
                "Основание Санкт-Петербурга",
                "Петр I основал город Санкт-Петербург",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "27 мая 1703"
        ));

        events.add(new HistoricalEvent(
                "Бородинское сражение",
                "Крупнейшее сражение Отечественной войны 1812 года",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "7 сентября 1812"
        ));

        events.add(new HistoricalEvent(
                "Отмена крепостного права",
                "Александр II подписал манифест об отмене крепостного права",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "19 февраля 1861"
        ));

        events.add(new HistoricalEvent(
                "Октябрьская революция",
                "Вооруженное восстание в Петрограде, приведшее к свержению Временного правительства",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "7 ноября 1917"
        ));

        events.add(new HistoricalEvent(
                "Начало Великой Отечественной войны",
                "Нападение фашистской Германии на СССР",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "22 июня 1941"
        ));

        events.add(new HistoricalEvent(
                "Победа в Великой Отечественной войне",
                "Капитуляция фашистской Германии. День Победы",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "9 мая 1945"
        ));

        events.add(new HistoricalEvent(
                "Запуск первого искусственного спутника",
                "СССР запустил первый искусственный спутник Земли",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "4 октября 1957"
        ));

        events.add(new HistoricalEvent(
                "Распад СССР",
                "Прекращение существования СССР как государства",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "26 декабря 1991"
        ));

        events.add(new HistoricalEvent(
                "Ледовое побоище",
                "Битва на Чудском озере между русским войском и немецкими рыцарями",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "5 апреля 1242"
        ));

        events.add(new HistoricalEvent(
                "Стояние на реке Угре",
                "Окончательное освобождение Руси от ордынского ига",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "11 ноября 1480"
        ));

        events.add(new HistoricalEvent(
                "Смутное время",
                "Начало периода гражданской войны в России",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "1598-1613"
        ));

        events.add(new HistoricalEvent(
                "Северная война",
                "Победа России в войне со Швецией",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "1700-1721"
        ));

        events.add(new HistoricalEvent(
                "Восстание декабристов",
                "Выступление революционеров на Сенатской площади",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "14 декабря 1825"
        ));

        events.add(new HistoricalEvent(
                "Крымская война",
                "Оборона Севастополя",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "1853-1856"
        ));

        events.add(new HistoricalEvent(
                "Русско-японская война",
                "Начало военных действий между Российской империей и Японией",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "1904-1905"
        ));

        events.add(new HistoricalEvent(
                "Первая русская революция",
                "Начало первой русской революции",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "1905-1907"
        ));

        events.add(new HistoricalEvent(
                "Февральская революция",
                "Свержение монархии в России",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "февраль 1917"
        ));

        events.add(new HistoricalEvent(
                "Полет Терешковой",
                "Первый полет женщины-космонавта",
                "https://gp-selskayapravda.ru/media/project_smi3_712/23/6f/82/da/70/9d/10-69.jpg",
                "16 июня 1963"
        ));

        return events;
    }
}