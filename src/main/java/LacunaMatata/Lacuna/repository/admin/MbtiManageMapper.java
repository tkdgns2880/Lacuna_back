package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.entity.mbti.MbtiCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MbtiManageMapper {
    List<MbtiCategory> getMbtiCategoryList();
    int registerMbtiCategory(MbtiCategory mbtiCategory);
    MbtiCategory findByCategoryId(int categoryId);
}
