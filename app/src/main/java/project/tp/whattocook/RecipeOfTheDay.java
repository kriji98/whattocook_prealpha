package project.tp.whattocook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class RecipeOfTheDay extends AppCompatActivity {

    private FeatureCoverFlow coverFlow;
    private CoverFlowAdapter adapter;
    private ArrayList<PopularRecipe> PopularRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_of_the_day);
        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);

        settingDummyData();
        adapter = new CoverFlowAdapter(this, PopularRecipes);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());
    }

    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActiivty", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");
            }
        };
    }

    private void settingDummyData() {
        PopularRecipes = new ArrayList<>();
        PopularRecipes.add(new PopularRecipe(R.drawable.limonov_chiizkeik, "Лимонов чийзкейк", "50", "Зa блата: 300 г. бисквити," +
                " 200 г. смлени чаени ядки, 150 г. меко масло, 150 г меко, За крема: 250 г. крема сирене, 250 г. извара," +
                " 200 г. захар, 400 г. заквасена сметана, 30 г. желатин, сокът и кората на 1 лимон, 50 мл. лимонов ликьор," +
                " 1 ампула ванилия, За желето: 150 мл. вода, сокът и кората на 1 лимон, 50 г. захар, 1/2 капсула лимонова есенция," +
                " 25 мл. лимонов ликьор, 1 пакетче желатин", "Смлените бисквити и ядки се объркват с разтопеното масло и тази смес" +
                " се притиска към дъното на подходяща форма с махащи се стени, за да се оформи блата на чийзкейка. Желатинът за крема" +
                " се накисва в нужното количество вода. Останалите съставки за крема се разбиват с миксер до хомогенност и към тях се" +
                " добавя разтопения и леко охладен желатин. Кремът се излива върху блата и чийзкейкът се слага в хладилник да се стегне." +
                " За желираното покритие смесете водата, сока и кората на лимона и ги кипнете за няколко минути в съд на котлона. " +
                "Добавете към тях захарта, есенцията, ликьора и набъбналия желатин. Бъркайте до неговото разтваряне. Желето се оставя" +
                " в хладилника да стегне и леко да стегне. Сипва се върху вече стегналия лимонов чийзкейк и се приглажда. Връща се в" +
                " хладилника за няколко часа преди чийзкейкът да се поднесе."));

        PopularRecipes.add(new PopularRecipe(R.drawable.salata_s_carevica_i_kedrovi_qdki, "Салата с ядки, семена и царевица", "15", "1 зелена салата, слънчогледови семки," +
                " тиквени семки, кедрови ядки, орехови ядки, царевица, сол, оцет, олио", "Зелената салата се нарязва и към" +
                " нея се добавят обелените семена, почистените от костилките ядки и царевицата (от консерва). Количеството" +
                " на продуктите е по ваше желание. Подправете салатата със сол, оцет и олио и разбъркайте. Добър апетит!"));

        PopularRecipes.add(new PopularRecipe(R.drawable.palachinki, "Палачинки", "30", "4 яйца, 600 мл. прясно мляко, 300 гр. брашно, 1 пакетче ванилия, щипка сол," +
                " 1 с.л. захар, конфитюр или шоколад за плънка", "Разбъркайте яйцата със захарта и щипка сол. След това, добавете на" +
                " части прясното мляко и продължете да бъркате. Накрая, остана само да добавите брашното и да бъркате, докато се" +
                " получи хомогенна смес. Сложете тиганът на котлона и капнете няколко капки олио. Щом тигана се загрее, с помощта " +
                "на черпак, вземайте от сместа (х 2/3 черпак за 1 палачинка) и слагайте в тигана. С въртеливи движения, разпределете" +
                " сместа по цялото дъно. Пържете палачинките и от двете страни. Готовите палачинки, редете в чиния. Намажете с" +
                " конфитюр или шоколад и навийте."));

        PopularRecipes.add(new PopularRecipe(R.drawable.salata_s_kuskus, "Салата с кускус", "30", "1 ч.ч. кускус, 4 бр. домати, 1 бр.краставици, 4 ч.л. майонеза, зелен лук, магданоз, сол, олио", "Кускусът се сварява до готовност в " +
                "солена вода, прецежда се и се изплаква със студена вода. Доматите се отрязват леко по диагонал и се почистват" +
                " от вътрешността (не се изхвърля, а се нарязва на ситно), краставицата се реже на много мънички парченца, лукът" +
                " и магданозът се нарязват на ситно. В купа сипваме нарязаните домати, краставица, кускус, лук и магданоз, овкусяваме" +
                " с олио и сол и сервираме. Част от салатата пълним в доматите, друга част слагаме направо в чинията, декорираме с майонезата и зелен лук."));

        PopularRecipes.add(new PopularRecipe(R.drawable.kufteta_ot_kaima_s_oriz, "Кюфтета от кайма с ориз", "60", "250 г. кайма, 1 ч.ч. сварен ориз," +
                " 5 стръка магданоз, 1 к.ч. брашно за овалване, 100 мл. олио за пържене - 100, 2 щипки смлян кимион, сол на вкус", "Оризът се сварява и" +
                " отцежда добре. В купа смесваме каймата, ориза, нарязан ситно магданоз, кимион и щипка сол. Омесената кайма се " +
                "разделя на 8-9 топчета. Оформят се средни кюфтенца. Всяко се овалва в брашно, изтупва се от излишното. Загрява " +
                "се олиото в тиган, пържим кюфтенцата от двете страни. Поднасяме със зелена салата. Бързо и вкусно!"));

        PopularRecipes.add(new PopularRecipe(R.drawable.bob_s_nadenica, "Боб с наденица ⭐", "120", "2 ч.ч. боб, 400 г. наденица, 1 морков," +
                " 1 глава лук, 1 червена чушка, 1 зелена чушка, 1 с.л. чубрица, 1 с.л. червен пипер, 4 с.л. олио, сол", "Бобът се накисва за 6 – 8 часа" +
                " в студена вода. След това водата се излива, бобът се измива, залива се с вода и се вари до омекване. На кубчета" +
                " се нарязват се лукът, зелената чушка, червената чушка и морковът. Запържват се в олиото" +
                " за 2 минути и след това се изсипват в тенджерата с варения боб. Ястието се вари още 30 минути на слаб" +
                " огън, като се подправя с чубрица, червен пипер и сол. С остър нож наденицата се нарязва" +
                " на колелца, като се оставя цяла, вместо на отделни парчета. Изпича се във фурна, докато стане сочна и хване" +
                " коричка. Във всяка порция боб се поставя парче наденица."));

        PopularRecipes.add(new PopularRecipe(R.drawable.tarator_s_krastavici_i_marulq, "Таратор с краставици и маруля", "15", "500 г. кисело мляко," +
                " 500 мл. вода, 1 бр.краставици, 1 бр. малка маруля, 4 скилидки чесън, сол, олио, копър", "Нарязват се марулята и краставицата на ситно." +
                " Разбива се млякото, долива се водата със солта. Смесват се млякото и зеленчуците. Сипва се олиото и се ръси " +
                "копърът. Слага се счуканият чесън."));

        PopularRecipes.add(new PopularRecipe(R.drawable.rulo_ot_bekon_i_pileshko_file, "Руло от бекон и пилешко филе", "85", "600 г. бекон, 300 г. пилешко филе," +
                " 2 бр. картофи, кашкавал, топено сирене, зелен лук, соев сос, червен пипер, черен пипер, олио, сол, магданоз", "Беконът нарязваме на тънки ивици с" +
                " уред за рязане. Посоляваме и поръсваме с черния и червения пипер. Пилешкото филе го начукваме и леко осоляваме. Картофите се изпържват. Формата, в" +
                " която ще печем рулото, намазваме с олио и редим бекончетата, първо на дъното и после по стените. Отдолу редим пилешкото, след което пържените картофи," +
                " топеното сирене, пресния лук и кашкавала. Започваме да затваряме рулото с бекона. Намазваме със соев сос и печем за около час, след което настъргваме " +
                "кашкавал и оставяме за малко, колкото да се разтопи кашкавалът."));

        PopularRecipes.add(new PopularRecipe(R.drawable.vuzdushni_qica_na_ochi, "Въздушни яйца на очи", "20", "2 бр. яйца, листа пресен чесън," +
                " черен пипер, сол, 1 ч.л. оцет", "Внимателно се отделят белтъците и жълтъците, като внимаваме да не се спукат жълтъците. Белтъците разбиваме с миксер на пухкава гъста" +
                " пяна заедно с оцета. След като сме разбили белтъците ги разделяме на две и слагаме върху хартия за печене" +
                " , като ги оформяме като облаче. Слагаме ги да се пекат за 5 минути на 200 градуса" +
                " във фурната и след това изваждаме и слагаме отгоре в центъра по един жълтък, връщане във фурната за още 10 минути " +
                "или до готовност. След като ги извадим от фурната ги поръсваме със ситно нарязан чесън, сол и черен пипер."));

        PopularRecipes.add(new PopularRecipe(R.drawable.qgodova_supa, "Ягодова супа", "20", "500 г. пресни ягоди, 250 г. захар, 300 мл. бяло вино, " +
                "500 мл. студена вода, от 1/2 лимон лимонов сок, 1 шепа пресни листа мента, заквасена сметана за сервиране", "Измийте добре ягодите" +
                " и ги почистете от дръжките. Отделете няколко по-твърди ягоди. Останалите сложете в блендер и налейте виното, водата" +
                " и лимоновия сок. Сипете захарта и половината от ментовите листа. Пюрирайте всичко до гладка еднородна смес. Може да" +
                " използвате и пасатор за тази цел, ако не разполагате с блендер. Охладете добре. Разлейте супата в купички. Нарежете" +
                " останалите ягоди на парченца и ги прибавете отгоре. Гарнирайте всяка порция с лъжица заквасена сметана и листенца мента."));
    }
}