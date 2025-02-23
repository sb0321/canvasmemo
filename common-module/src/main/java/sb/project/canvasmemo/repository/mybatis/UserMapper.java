package sb.project.canvasmemo.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import sb.project.canvasmemo.entity.User;

@Mapper
public interface UserMapper {

    User findById(long id);
}
