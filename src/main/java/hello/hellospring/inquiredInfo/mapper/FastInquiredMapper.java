    package hello.hellospring.inquiredInfo.mapper;

    import hello.hellospring.inquiredInfo.domain.FastInquired;
    import org.apache.ibatis.annotations.Mapper;

    import java.util.List;

    @Mapper
    public interface FastInquiredMapper {
        Long getLastId();
        void InsertFastInquired(FastInquired fastInquired);
        List<FastInquired> getFastInquiredList();
        void DeleteFastInquired(Long id);
        void SuccessFastInquired(Long id);
    }
