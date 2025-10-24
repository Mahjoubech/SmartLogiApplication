//package io.github.Mahjoubech.smartlogi.service;
//
//// ... imports ...
//import io.github.Mahjoubech.smartlogi.dto.LivreurDto;
//import io.github.Mahjoubech.smartlogi.entity.Livreur;
//import org.junit.jupiter.api.*;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.Optional;
//
//public class LivreurServiceImplTest {
//
//    private static ApplicationContext context;
//    private static LivreurService livreurService;
//
//    @BeforeAll
//    static void setUp() {
//        context = new ClassPathXmlApplicationContext("application-context.xml");
//        livreurService = (LivreurService) context.getBean("livreurService");
//    }
//
//    @AfterAll // ✅ التصحيح 1: إغلاق الـ Context بعد انتهاء جميع الاختبارات
//    static void tearDown() {
//        if (context instanceof ClassPathXmlApplicationContext) {
//            ((ClassPathXmlApplicationContext) context).close();
//            System.out.println("✅ Spring Context a été fermé.");
//        }
//    }
//
//    @Test
//    void testCreateAndFindById() {
//        // GIVEN
//        LivreurDto dto = new LivreurDto("Zouhairi", "Karim", "Van", "0699887766");
//
//        // WHEN
//        Livreur savedLivreur = livreurService.create(dto);
//
//        // THEN
//        Assertions.assertNotNull(savedLivreur.getId(), "L'ID ne doit pas être null après l'enregistrement.");
//
//        Optional<Livreur> found = livreurService.getLivreurById(savedLivreur.getId());
//        Assertions.assertTrue(found.isPresent(), "Le livreur doit être trouvé.");
//        Assertions.assertEquals("Karim", found.get().getPrenom());
//
//        // ✅ التصحيح 2: تنظيف البيانات المضافة
//        livreurService.delete(savedLivreur.getId());
//    }
//}