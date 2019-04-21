package jim.pers.jerp.mapper;

import java.util.List;

import jim.pers.jerp.model.Program;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProgramMapper {
	public List<Program> getProgram();
}
