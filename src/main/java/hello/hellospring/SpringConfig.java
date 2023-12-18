package hello.hellospring;


import hello.hellospring.repository.AdminRepository.AdminRepository;
import hello.hellospring.repository.AdminRepository.JpaAdminRepository;
import hello.hellospring.repository.BannerRepository.BannerRepository;
import hello.hellospring.repository.BannerRepository.JpaBannerRepository;
import hello.hellospring.repository.CarRepository.CarRepository;
import hello.hellospring.repository.CarRepository.JpaCarRepository;
import hello.hellospring.repository.InquiredRepository.InquiredRepository;
import hello.hellospring.repository.InquiredRepository.JpaInquiredRepository;
import hello.hellospring.repository.customeruploadRepository.CustomerUploadRepository;
import hello.hellospring.repository.customeruploadRepository.JpaCustomeruploadRepository;
import hello.hellospring.repository.fastinquiredrepository.FastinquiredRepository;
import hello.hellospring.repository.fastinquiredrepository.JpaFastinquiredRepository;
import hello.hellospring.repository.memberrepository.JpaMemberRepository;
import hello.hellospring.repository.memberrepository.MemberRepository;
import hello.hellospring.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        //return new JdbcMemberRepository(dataSource);
        //return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }
    @Bean
    public FastinquiredRepository fastinquiredRepository(){
        return new JpaFastinquiredRepository(em);
    }
    @Bean
    public FastinquiredService fastinquiredService(){
        return new FastinquiredService(fastinquiredRepository());
    }
    @Bean
    public CustomerUploadRepository customerUploadRepository(){ return new JpaCustomeruploadRepository(em);}
    @Bean
    public CustomerUploadService customerUploadService() { return new CustomerUploadService(customerUploadRepository());}
    @Bean
    public AdminRepository adminRepository() {return new JpaAdminRepository(em);}
    @Bean
    public AdminService adminService() {return new AdminService(adminRepository());}
    @Bean
    public SessionManager sessionManager(){ return new SessionManager();}
    @Bean
    public BannerRepository bannerRepository() {return new JpaBannerRepository(em);}
    @Bean
    public BannerService bannerService() {return new BannerService(bannerRepository());}
    @Bean
    public InquiredRepository inquiredRepository(){return new JpaInquiredRepository(em);}
    @Bean
    public InquiredService inquiredService() {return new InquiredService(inquiredRepository());}
    @Bean
    public CarRepository carRepository() {return new JpaCarRepository(em);}
    @Bean
    public CarService carService() {return new CarService(carRepository());}
}
