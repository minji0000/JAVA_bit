package controller;

import model.MovieDTO;

import java.util.ArrayList;

public class MovieController {

    private ArrayList<MovieDTO> movieList;
    private int nextId;


    public MovieController() {
        movieList = new ArrayList<>();
        nextId = 1;

        MovieDTO temp1 = new MovieDTO();
        MovieDTO temp2 = new MovieDTO();
        MovieDTO temp3 = new MovieDTO();

        //샘플 영화 목록
        temp1.setTitle("기생충");
        temp1.setContent("제시카 외동딸 일리노이 시카고, 과 선배는 김진모 그는 네 사촌");
        temp1.setMovieGrade(15);

        insert(temp1);

        temp2.setTitle("관상");
        temp2.setContent("어찌 내가 왕이 될 상인가");
        temp2.setMovieGrade(15);

        insert(temp2);

        temp3.setTitle("7번방의 선물");
        temp3.setContent("예승이 콩 먹어 콩 비타민");
        temp3.setMovieGrade(12);

        insert(temp3);
    }

    public void insert(MovieDTO m) {
        m.setMovieId(nextId++);
        movieList.add(m);
    }


    public void setMovieList(int movieId, String title, String content, int movieGrade) {
        MovieDTO m = new MovieDTO();
        m.setMovieId(movieId);
        m.setMovieGrade(movieGrade);
        m.setTitle(title);
        m.setContent(content);

        movieList.add(m);
    }

    public ArrayList<MovieDTO> printAll() {
        ArrayList<MovieDTO> temp = new ArrayList<>();

        for(MovieDTO movieDTO : movieList) {
            temp.add(new MovieDTO(movieDTO));
        }
        return temp;
    }

    public MovieDTO selectOne(int id) {
        for(MovieDTO movieDTO : movieList ) {
            if(movieDTO.getMovieId() == id) {
               return new MovieDTO(movieDTO);
            }
        }
        return null;
    }

    // 리스트의 특정 객체를 수정하는
    // update()
    public void update(MovieDTO m) {
        int index = movieList.indexOf(m);
        movieList.set(index, m);
    }

    // 리스트의 특정 객체를 삭제하는
    // delete
    public void delete(int id) {
        movieList.remove(new MovieDTO(id));
    }

    //리스트의 특정 회원의 글을 삭제하는
    //deleteByWriterId()
    public void deleteByWriterId(int movieId) {
        for(int i = 0; i < movieList.size(); i++) {
            MovieDTO m = movieList.get(i);
            if(m.getMovieId() == movieId) {
                movieList.remove(m);
                i = -1;
                //for문을 다시 처음부터 하려고 i를 -1로 만듦 ---> 다음 i++ 돼서 i = 0;
            }
        }
    }





}
