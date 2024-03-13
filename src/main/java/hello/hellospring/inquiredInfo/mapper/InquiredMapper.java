package hello.hellospring.inquiredInfo.mapper;

import hello.hellospring.inquiredInfo.domain.FastInquired;
import hello.hellospring.inquiredInfo.domain.Inquired;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface InquiredMapper {
    Long getLastId();
    void InsertInquired(Inquired inquired);
    List<Inquired> getInquiredList();
    void DeleteInquired(Long id);
    void SuccessInquired(Long id);
}
