import SearchPage from "../../../pages/serch/SerchPage";
import { qs } from "../../../util/helpers";

export default class SearchFormView extends SearchPage {
  constructor() {
    super(qs("SearchBox"));

    this.resetElement = qs("[type=reset]", this.element);

    // 검색 x 버튼을 안보이게
    this.hideResetButton();
  }

  hideResetButton() {
    this.resetElement.style.display = "none";
  }
}
