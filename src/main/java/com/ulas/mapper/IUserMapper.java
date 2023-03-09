package com.ulas.mapper;

import com.ulas.dto.request.MovieCommentCreateRequestDto;
import com.ulas.dto.request.UserRegisterRequestDto;
import com.ulas.dto.response.LoginResponseDto;
import com.ulas.repository.entity.MovieComment;
import com.ulas.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);
    User toUser(final UserRegisterRequestDto dto);
    LoginResponseDto toLoginResponseDto(final User user);
    MovieComment toMovieComment(final MovieCommentCreateRequestDto dto);

}
