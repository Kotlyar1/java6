public class HOME6 {
  /**
   * Задача: реализовать волновой алгоритм.
   * Т.к. других комментариев к условию задачи нет, будем считать,
   * что перед нами стоит задача найти минимальный путь от точки А до точки В
   * (путь в лабиринте) используя алгоритм волновой трассировки (Алгоритм Ли) ,
   * который основан на методе поиска на графе в ширину. В матрице лабиринта числа
   * 99 - препятствия, 33 - свободные клетки, 0 - начало маршрута, 11 - окончание.
   * Основное условие задачи - реализовать волновой алгоритм - выполнена.
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Инициализация переменных
    int i = 0;
    int z = 0;
    int k = 0;
    int j = 0;
    int Ni = 0;
    // int Nk = 256;
    int n = 10;

    // Матрица лабиринта
    int lab[][] = {
        { 99, 99, 99, 99, 99, 33, 33, 33, 33, 33 },
        { 11, 33, 33, 33, 99, 33, 33, 33, 33, 33 },
        { 33, 33, 33, 33, 99, 33, 33, 33, 33, 33 },
        { 33, 33, 33, 33, 33, 33, 33, 33, 33, 33 },
        { 33, 33, 33, 33, 33, 99, 99, 33, 33, 33 },
        { 33, 33, 33, 33, 33, 0, 33, 33, 33, 33 },
        { 33, 33, 33, 33, 33, 33, 99, 33, 33, 33 },
        { 33, 33, 33, 33, 33, 33, 33, 33, 33, 33 },
        { 33, 33, 33, 33, 33, 33, 33, 33, 33, 33 },
        { 33, 33, 33, 33, 33, 33, 33, 33, 33, 33 },
        { 33, 33, 33, 33, 33, 33, 33, 33, 33, 33 } };

    // инициализация матрицы пути
    int kurs[][] = new int[n][n];
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        kurs[i][j] = 22;
      }
    }

    // Три цикла прохождения матрицы лабиринта
    label: for (int l = 0; l < 256; l++) {
      for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {

          // Условия распространения волны
          if (lab[i][j] == Ni && i > 0 && i < n && j > 0 && j < n - 1) {

            if (lab[i][j + 1] == 33) {
              lab[i][j + 1] = Ni + 1;
            }
            if (lab[i][j + 1] == 11) {
              z = i;
              k = j + 1;
              break label;
            }
            if (lab[i + 1][j] == 33) {
              lab[i + 1][j] = Ni + 1;
            }
            if (lab[i + 1][j] == 11) {
              z = i + 1;
              k = j;
              break label;
            }
            if (lab[i][j - 1] == 33) {
              lab[i][j - 1] = Ni + 1;
            }
            if (lab[i][j - 1] == 11) {
              z = i;
              k = j - 1;
              break label;
            }
            if (lab[i - 1][j] == 33) {
              lab[i - 1][j] = Ni + 1;
            }
            if (lab[i - 1][j] == 11) {
              z = i - 1;
              k = j;
              break label;
            }
          }
        }
      }
      // Коэффициент распространения волны
      Ni++;
    }
    // Вывод волны
    System.out.println();
    System.out.println("Вывод волны");
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        System.out.printf("%4d", lab[i][j]);
      }
      System.out.println();
    }
    lab[z][k] = Ni + 1;
    Ni++;

    // Печать
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        if (lab[z][k] >= lab[z + 1][k]) {
          kurs[z][k] = Ni;
          z = z + 1;
          Ni--;
        }
        if (lab[z][k] >= lab[z - 1][k]) {
          kurs[z][k] = Ni;
          z = z - 1;
          Ni--;
        }
        if (lab[z][k] >= lab[z][k + 1]) {
          kurs[z][k] = Ni;
          k = k + 1;
          Ni--;
        }
        if (lab[z][k] >= lab[z][k - 1]) {
          kurs[z][k] = Ni;
          k = k - 1;
          Ni--;
        }
        kurs[z][k] = Ni;
      }
    }
    // Вывод кратчайшего пути
    System.out.println();
    System.out.println("Вывод кратчайшего пути");
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        System.out.printf("%4d", kurs[i][j]);
      }
      System.out.println();
    }
  }
}