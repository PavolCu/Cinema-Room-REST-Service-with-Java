package cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    public static class Seat {
        private int row;
        private int column;

        public Seat(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }

    public static class Cinema {
        private int rows;
        private int columns;
        private List<Seat> seats;

        public Cinema(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            this.seats = new ArrayList<>();
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= columns; j++) {
                    this.seats.add(new Seat(i, j));
                }
            }
        }

        public int getRows() {
            return rows;
        }

        public int getColumns() {
            return columns;
        }

        public List<Seat> getSeats() {
            return seats;
        }
    }

    @GetMapping("/seats")
    public Cinema getSeats() {
        return new Cinema(9, 9);
    }

}
